Ext.define('app.ocean.ssm.common.request', {
    singleton: true,
    url:function(url){
        // todo 获取当前项目的ContextPath
        return '/ssm'+url;
    },
    request: function (params, url) {
        if (!url || typeof(url) == 'undefined'){
            return;
        }
        var message = null;
        var exceptionStr = "服务器异常,请稍后重试!";
        var responseData = null;
        var status = false;
        Ext.Ajax.request({
            url: url,
            method: "post",
            params: params,
            async: false,
            success: function (response) {
                if (response.status != 200) {
                    message = exceptionStr;
                    return;
                }
                var data = JSON.parse(response.responseText);
                if (data.status) {
                    status = true;
                    responseData = data.resultData;
                    return;
                }
                //区分业务异常和系统异常
                message = data.statusCode == '300'?data.message:exceptionStr;
            },
            failure: function () {
                message = exceptionStr;
            }
        });
        if (!status) {
            throw new BizException(message,'');
        }
        return responseData;
    }
});
function BizException(message,result){
    var data;
    data.message = message;
    data.result = result;
    return data;
}