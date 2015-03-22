$(function () {
    var ENTER_KEY = 13;
    var ESCAPE_KEY = 27;

    var util = {
        makeTodoList: function(id, title) {
            return "<li class='active' data-id=" + id + ">" +
                "<div class='view'>" +
                "<input class='toggle' type='checkbox' />" +
                "<label>" + title + "</label>" +
                "<button class='destroy'></button>" +
                "</div>" +
                "<input class='edit' value='" + title + "'/>" +
                "</li>";
        },

        isChecked: function ($check_box) {
            return !!$check_box.prop("checked");
        },

        query: function (state, argument, func) {
            $.post("/query", {state: state, argument: argument}, func);
        }
    };

    var App = {
        init: function () {
            this.cacheElements();
            this.bindEvents();
        },

        renderFooter: function () {
            util.query("active", "count", function (jsonData) {
                App.activeCount = JSON.parse(jsonData);
                App.$count.find("strong").text(App.activeCount);
            });
        },

        cacheElements: function () {
            this.$todoApp = $('#todoapp');
            this.$header = this.$todoApp.find('#header');
            this.$main = this.$todoApp.find('#main');
            this.$footer = this.$todoApp.find('#footer');
            this.$newTodo = this.$header.find('#new-todo');
            this.$toggleAll = this.$main.find('#toggle-all');
            this.$todoList = this.$main.find('#todo-list');
            this.$count = this.$footer.find('#todo-count');
            this.$clearBtn = this.$footer.find('#clear-completed');
        },

        bindEvents: function () {
            var list = this.$todoList;
            //add
            this.$newTodo.on('keyup', this.add.bind(this));
            //delete
            list.on('click', '.destroy', this.destroy.bind(this));
            //update
            list.on('dblclick', 'label', this.edit.bind(this));
            list.on('keyup', '.edit', this.editKeyup.bind(this));
            list.on('focusout', '.edit', this.update.bind(this));
            //toggle
            list.on('change', '.toggle', this.toggle.bind(this));
            //toggleAll
            this.$toggleAll.on('change', this.toggleAll.bind(this));
            //clear-completed
            this.$footer.on('click', '#clear-completed', this.destroyCompleted.bind(this));
        },

        add: function (e) {
            var $input = $(e.target);
            var title = $input.val().trim();

            if (e.which !== ENTER_KEY || !title ) {
                return;
            }
            $.ajax({
                url: "/user/add",
                data: {title: title},
                type: "POST",
                success: function (jsonData) {
                    console.log("add success");
                    var todo = JSON.parse(jsonData);
                    $("#todo-list").append(util.makeTodoList(todo.id, todo.title));
                    $input.val("");
                    App.renderFooter();
                }
            });
        },

        destroy: function (e) {
            var $li = $(e.target).closest("li");
            var id = $li.data("id");
            console.log(id);
            $.ajax({
                url: "/delete",
                data: {id: id, argument: "one"},
                type: "POST",
                success: function () {
                    $li.remove();
                    App.renderFooter();
                }
            });
        },

        edit: function (e) {
            var $input = $(e.target).closest("li").addClass("editing").find(".edit");
            $input.val($input.val()).focus();
        },

        editKeyup: function (e) {
            if (e.which === ENTER_KEY) {
                e.target.blur();
            }

            if (e.which === ESCAPE_KEY) {
                $(e.target).data('abort', true).blur();
            }
        },

        update: function (e) {
            var el = e.target;
            var $el = $(el);
            var $li = $(e.target).closest("li");
            var $label = $li.find("label");

            var id = $(e.target).closest("li").data("id");
            var title = $el.val().trim();
            var $check_box = $li.find(".toggle");

            if ($el.data('abort')) {
                $el.data('abort', false);
                $li.removeClass("editing");
                $li.find(".edit").val('');
                return;
            }

            $.ajax({
                url: "/update",
                data: {id: id, title: title, state: util.isChecked($check_box)},
                type: "POST",
                success: function () {
                    $label.text(title);
                    $li.removeClass("editing");
                }
            });
        },

        toggle: function (e) {
            var $check_bok = $(e.target);
            var $li = $check_bok.closest("li");
            var id = $li.data("id");
            var title = $li.find(".edit").val();
            $.ajax({
                url: "/update",
                data: {id: id, title: title, state: util.isChecked($check_bok)},
                type: "POST",
                success: function () {
                    console.log(util.isChecked($check_bok));
                    $check_bok.closest("li").toggleClass("completed");
                    App.renderFooter();
                }
            });
        },

        toggleAll: function (e) {
            var isChecked = $(e.target).prop('checked');
            console.log(isChecked);
            $.post("/update", {id: 0, title: "", state: isChecked, argument: "all"}, function () {
                //toggle all checkbox
                $("#todo-list :checkbox").prop("checked", isChecked);
                //$("ul li").toggleClass("completed");
                $("ul li").each(function () {
                    if(isChecked) {
                        $(this).addClass("completed");
                    }else {
                        $(this).removeClass("completed");
                    }
                });
                App.renderFooter();
            });
        },

        destroyCompleted: function (e) {
            $.post("/delete", {id: 0, argument: "all-completed"}, function () {
                //refresh list
                $("#todo-list :checkbox").each(function () {
                    console.log(util.isChecked($(this)));
                    if(util.isChecked($(this)) == true){
                        $(this).closest("li").remove();
                    }
                });
                App.$toggleAll.prop("checked", false);
                App.renderFooter();
            });
        }
    };

    App.init();

});