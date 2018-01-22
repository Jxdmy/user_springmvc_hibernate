$(function() {
	var $job_form = $('#job_form')
	var $content = $("#content")
    var $content_job = $("#content_job")

    $content_job.find('.add_job').on('click', function() {
        // 发起一个加载局部页面的请求
        // 第一个参数是url，请求路径
        // 第二个参数是data，发送数据，可选
        // 第三个参数是callback，回调函数
        $content.load('http://localhost:8080/user_springmvc_hibernate/job/addJob')
    })
    
    $job_form.on('submit', function() {
    	var jobname = $job_form.find('input[name="job"]')
    	
    	if (jobname.val().length < 4 || jobname.val().length > 14) {
			alert("职业名长度在4-14个字符之间");
			return false;
		}
    })
})