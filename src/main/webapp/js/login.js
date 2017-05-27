var Login={
    init:function(options){
        if(options.h.indexOf(";")!=-1){
            options.h=options.h.split(";")[0];
        }
        var Eic = {
            Login: {
                "processUrl": options.h+"/system/process"
            }
        };
        var loading = '<div class="loadingBox"><div class="loading"><img src='+options.h+'"/img/loading.gif"></div><div id="dialog-box-mask"></div></div>';
        var loginProcessing= false;

        $(function () {
            function getCookie(name) {
                var arr, reg = new RegExp("(^| )" + name + "=([^;]*)(;|$)");
                if (arr = document.cookie.match(reg))
                    return unescape(arr[2]);
                else
                    return null;
            }

            var body = $("body");
            var dialogBox = '<div class="dialog-box">';
            dialogBox += '<div class="dialog-title">请输入动态口令<span class="dialog-close"></span></div>';
            dialogBox += '<input type="text" class="login-input dialog" name="dynamic" id="dynamicPassword"/>';
            dialogBox += '<input type="button" class="login-button dialog" id="dynamic" value="确 认"/></div><div id="dialog-box-mask"></div>';
            function _isSuccess(data) {
                return (typeof (data.success) == 'boolean' && data.success ) || data.success == 'true';
            }



            body.bind('keypress', function (event) {
                if (event.keyCode == "13") {
                    $(".login-button").trigger("click");
                }
            });
            RSAUtils.setMaxDigits(200);
            var publicKey = options.k.split(":");
            var publicKeyExponent = publicKey[0];
            var publicKeyModulus = publicKey[1];
            var key = new RSAUtils.getKeyPair(publicKeyExponent, "", publicKeyModulus);
            //弹窗处理
            $(".login-button").on("click", function () {
                var loginId = $("#loginId").val();
                var password = $("#password").val();
                var otp = $("#otp").val();
                //var loginVerifyCode= $("#loginVerifyCode").val();
                //var url = $("#url").val();
                /*if(!loginProcessing){
                    loginProcessing= true;*/
                    $.ajax({
                        type: "post",
                        data: {
                            username: loginId,
                            password: RSAUtils.encryptedString(key, password),
                            otp:otp
                            //        appCode: $("#appCode").val()
                            //        loginVerifyCode:loginVerifyCode,
                            //        service: url
                        },
                        url: Eic.Login.processUrl,
                        dataType: "json",
                        success: function (data) {
                            if (_isSuccess(data)) {
                                window.location.href =options.h.substr(0,options.h.length-1) +data.message;
                            } else {
                                _showError(data);
                            }
                        },
                        error: function (data) {
                            _showError("请求错误");
                        }
                    });
             /*   }*/
                /* var loginId = $("#loginId").val();
                var password = $("#password").val();
                var loginVerifyCode= $("#loginVerifyCode").val();
                //first try to auth check
                $.ajax({
                    type: "post",
                    data: {
                        username: loginId,
                        loginVerifyCode:loginVerifyCode,
                        password: RSAUtils.encryptedString(key, password)
                    },
                    url: Eic.Login.authCheckUrl,
                    dataType: "json",
                    success: function (data) {
                        if (_isSuccess(data)) {
                            _doLogin();

                        } else {

                            _showError(data);
                        }
                    },
                    error: function (data) {
                        _showError("请求错误");
                    }
                });*/
            });
            //兼容处理防止message=#情况发生
            //兼容处理防止message=#情况发生
            var location = window.location.href.replace(window.location.hash,"");
            if (location.indexOf("code=") != -1) {
                var parameterParts = location.split("?")[1].split("&");
                var parameterIndex = 0 ;
                for(;parameterIndex<parameterParts.length;parameterIndex++){
                    if(parameterParts[parameterIndex].indexOf("message=")!=-1){
                        _showError(decodeURI(parameterParts[parameterIndex].split("=")[1]));
                    }
                }

            }

            function _showError(data) {
                loginProcessing = false;
                var message=data;
                var $dialog =$("#dialogBox");
                if(typeof data=='object'){
                    if (data.code == "CA007") {
                        $dialog.html(dialogBox);
                        return;
                    }
                    if (data.code == "CA006") {
                        window.location.href = data.message;
                        return;
                    }
                    if(data.code=='CA008'){
                        $("#loginVerifyCodePanel").show();
                    }
                    if(data.code!='CA001'){
                        _showError(data.message);
                    }
                    message=data.message;
                }
                if(message!=''){
                    $dialog.html(dialogBox);
                    var dialogError = '<div class="dialog-title">提示信息<span class="dialog-close"></span></div>';
                    dialogError += '<div class="dialog-error">' + message + '</div>';
                    $(".dialog-box").html(dialogError);
                }

            }
            //弹窗关闭
            body.on("click", ".dialog-close", function () {
                $("#phoneNo").val("");
                $(".dialog-box").remove();
                $("#dialog-box-mask").remove();
            });
        });
    }
};