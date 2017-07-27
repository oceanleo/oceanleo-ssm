Ext.define('app.lhy.ssm.common.request', {
    singleton: true,
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
            Ext.Msg.alert('<font size=4>温馨提示</font>','<font color=red>'+message+'</font>');
            //Ext.Msg.alert('温馨提示',message+'111');
            return;
            //throw new BizException(message,'');
        }
        return responseData;
    }
});
function BizException(message,result){
    var data = new Object();
    data.message = message;
    data.result = result;
    return data;
}