$(function() {
	var $hobby_form = $('#hobby_form')
	var $content = $("#content")
    var $content_hobby = $("#content_hobby")

   $content_hobby.find('.add_hobby').on('click', function() {
        // 发起一个加载局部页面的请求
        // 第一个参数是url，请求路径
        // 第二个参数是data，发送数据，可选
        // 第三个参数是callback，回调函数
        $content.load('http://localhost:8080/user_springmvc_hibernate/hobby/addHobby')
    })
    
    $hobby_form.on('submit', function() {
    	var hobbyname = $hobby_form.find('input[name="hobby"]')
    	
    	if (hobbyname.val().length < 4 || hobbyname.val().length > 14) {
			alert("爱好名长度在4-14个字符之间");
			return false;
		}
    })
})