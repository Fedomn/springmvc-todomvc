$(document).ready(function(){

    var $name_input = $('#new-todo');
    $name_input.keydown(function(e){
        if(e.keyCode==13){
            var user_name = $name_input.val();
            $.ajax({
                url:"/users/add",
                data:{user_name:user_name},
                type:"POST",
                success:function(json_user){
                    var user = json_user;
                    var $user_list = $("#todo-list");
                    $user_list.append(concatString(user.name,user.id));
                    $name_input.val("");
                }
            })
        }
    });

    $(".destroy").on("click",function(){
        var $li = $(this).closest("li");
        var user_id = $li.data("id");
        $.ajax({
            url:"/users/delete",
            data:{user_id:user_id},
            type:"POST",
            success:function(){
                $li.remove();
            }
        })
    });

    function concatString(user_name,user_id){
        var expectString =
            "<li data-id="+user_id+">"+
            "<div class='view'>"+
            "<a href='users/"+user_name+"/todos'>"+user_name+"</a>"+
            '<button class="destroy"></button>'+
            "</div>"+
            "</li>";
        return expectString;
    }
});
