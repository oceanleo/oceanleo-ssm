//dom 加载完成后触发
window.onload = function () {
    Ext.onReady(function () {
        //获取当前应用缩写名
        var app = _getApp();
        Ext.application({
            extend: 'Ext.app.Application',
            name: 'app',
            launch: function () {
                var me = this;
                me.callParent();
                //依赖行为基本配置
                Ext.Loader.setConfig({
                    disableCaching: false
                });
                //加载js 依赖
                //_loadDependencies(
                //_getScriptDomain(),
                //依赖加载完成
                //function () {
                Ext.setGlyphFontFamily('FontAwesome');
                //Ext['appContext'] = Ext.create('app.AppContext');
                //Ext['windowFrame'] = Ext.create('app.OpenViewContext');
                Ext.mainFrame = Ext.create(_getViewEntry(), {
                    renderTo: Ext.getBody()
                });
                //});
            }
        });

        function _getViewEntry() {
            //支持客户端重写
            //if (window.Context && window.Context.viewport) {
            //    return window.Context.viewport;
            //}
            //if (app.length == 0 || app.length == 1) {
            //    return "app.view.main.Main";
            //}
            return 'app.ocean.'+app+'.view.main.main';
        }

        function _getApp() {
            var context = document.location.pathname;
            var pathParts = context.split("/");
            return pathParts[1];
        }

        function _loadDependencies(scriptRootPath, callback) {
            var appDependencies = [];
            if (window.Context.dependencies) {
                appDependencies = window.Context.dependencies;
            }
            var defaultDependencies = [
                //"/ext/packages/ext-locale/build/ext-locale-zh_CN.js",
                //"/ext/packages/ext-ux/build/ext-ux-debug.js",
                //"/ext/packages/ext-charts/build/ext-charts.js",
                //"/ext/packages/ext-theme-crisp/build/ext-theme-crisp.js",
                //"/funi/core/DateTimePicker.js",
                //"/funi/core/DateTime.js"
            ];
            var excludeDependencies = [];
            var extDependencies = [];
            Ext.each(appDependencies, function (dd) {

                if (dd.indexOf("!") == 0) {
                    excludeDependencies.push(dd.substring(1, dd.length));
                } else {
                    defaultDependencies.push(dd);
                }
            });
            Ext.each(defaultDependencies, function (r) {
                var add = true;
                Ext.each(excludeDependencies, function (dd) {
                    if (r == dd) {
                        add = false;
                    }
                });
                if (add) {
                    extDependencies.push(r);
                }
            });

            function _load(i) {
                Ext.Loader.loadScript({
                    url: scriptRootPath + extDependencies[i],
                    onLoad: function () {
                        if (i > 0) {
                            _load(i - 1);
                        } else {
                            callback();
                        }
                    }
                });
            }
            _load(extDependencies.length - 1);
        }

        /**
         * 取得js源地址
         * @returns {*}
         * @private
         */
        //function _getScriptDomain() {
        //    var bootstrapUrl;
        //    for (var i = 0; i < document.scripts.length; i++) {
        //        if (document.scripts[i].src.indexOf('/ext/bootstrap.js') != -1) {
        //            bootstrapUrl = document.scripts[i].src;
        //        }
        //    }
        //    return bootstrapUrl.replace("/ext/bootstrap.js", "");
        //}
    });
};