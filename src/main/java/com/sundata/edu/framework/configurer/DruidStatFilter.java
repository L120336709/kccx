package com.sundata.edu.framework.configurer;

import com.alibaba.druid.support.http.WebStatFilter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * 配置监控拦截器 druid监控拦截器
 *
 * @ClassName: DruidStatFilter
 * @author whj
 * @date 2018年6月24日 上午10:54:27
 */
@WebFilter(filterName = "druidWebStatFilter", urlPatterns = "/*", initParams = {
		@WebInitParam(name = "exclusions", value = "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*"),// 忽略资源
})
public class DruidStatFilter extends WebStatFilter {
}
