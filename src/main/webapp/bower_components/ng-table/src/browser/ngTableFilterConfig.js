/**
 * ngTable: Table + Angular JS
 *
 * @author Vitalii Savchuk <esvit666@gmail.com>
 * @url https://github.com/esvit/ng-table/
 * @license New BSD License <http://creativecommons.org/licenses/BSD/>
 */
import * as ng1 from 'angular';
ngTableFilterConfigProvider.$inject = [];
/**
 * The angular provider used to configure the behaviour of the `ngTableFilterConfig` service.
 *
 * Implements the {@link IFilterConfigProvider IFilterConfigProvider} interface
 */
export function ngTableFilterConfigProvider() {
    var config;
    var defaultConfig = {
        defaultBaseUrl: 'ng-table/filters/',
        defaultExt: '.html',
        aliasUrls: {}
    };
    this.$get = ngTableFilterConfig;
    this.resetConfigs = resetConfigs;
    this.setConfig = setConfig;
    init();
    /////////
    function init() {
        resetConfigs();
    }
    function resetConfigs() {
        config = defaultConfig;
    }
    function setConfig(customConfig) {
        var mergeConfig = ng1.extend({}, config, customConfig);
        mergeConfig.aliasUrls = ng1.extend({}, config.aliasUrls, customConfig.aliasUrls);
        config = mergeConfig;
    }
    /////////
    ngTableFilterConfig.$inject = [];
    function ngTableFilterConfig() {
        var publicConfig;
        var service = {
            config: publicConfig,
            getTemplateUrl: getTemplateUrl,
            getUrlForAlias: getUrlForAlias
        };
        Object.defineProperty(service, "config", {
            get: function () {
                return publicConfig = publicConfig || ng1.copy(config);
            },
            enumerable: true
        });
        return service;
        /////////
        function getTemplateUrl(filterDef, filterKey) {
            var filterName;
            if (typeof filterDef !== 'string') {
                filterName = filterDef.id;
            }
            else {
                filterName = filterDef;
            }
            if (filterName.indexOf('/') !== -1) {
                return filterName;
            }
            return service.getUrlForAlias(filterName, filterKey);
        }
        function getUrlForAlias(aliasName, filterKey) {
            return config.aliasUrls[aliasName] || config.defaultBaseUrl + aliasName + config.defaultExt;
        }
    }
}
//# sourceMappingURL=ngTableFilterConfig.js.map