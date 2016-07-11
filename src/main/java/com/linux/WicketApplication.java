/*
 * Copyright (C) 2016 guru.a.kulkarni
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.linux;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;
import com.linux.home.HomePage;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.filter.JavaScriptFilteredIntoFooterHeaderResponse;
import org.apache.wicket.request.Url;
import org.apache.wicket.request.resource.CssResourceReference;
import org.apache.wicket.request.resource.JavaScriptResourceReference;
import org.apache.wicket.request.resource.ResourceReference;
import org.apache.wicket.request.resource.UrlResourceReference;

/**
 *
 * @author guru.a.kulkarni
 */
public class WicketApplication extends WebApplication{

    /** The Bucket / container name {@value #JS_FOOTER_CONTAINER_NAME} for rendering Javascript in the body of page.*/
    public static final String JS_FOOTER_CONTAINER_NAME = "footer-container";

    /** Resource bundle with name {@value #BOOTSTRAP_JS_BUNDLE} */
    public static final String BOOTSTRAP_JS_BUNDLE = "bootstrapJs";

    /** Resource bundle with name {@value #BOOTSTRAP_CSS_BUNDLE} */
    public static final String BOOTSTRAP_CSS_BUNDLE = "bootstrapCss";
    
    @Override
    public Class<? extends Page> getHomePage() {
        return HomePage.class;
    }

    @Override
    protected void init() {
        super.init();
        ResourceReference cssBootstrapReference = new UrlResourceReference(Url.parse("https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"));
        ResourceReference cssBootstrapThemeReference = new UrlResourceReference(Url.parse("https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css"));
        ResourceReference jsBootstrapReference = new UrlResourceReference(Url.parse("https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"));

        ResourceReference.Key cssBootstrapKey = new ResourceReference.Key(cssBootstrapReference);
        ResourceReference.Key cssBootstrapThemeKey = new ResourceReference.Key(cssBootstrapThemeReference);
        ResourceReference.Key jsBootstrapKey = new ResourceReference.Key(jsBootstrapReference);
    
        CssResourceReference bootstrapThemeCssResourceReference = new CssResourceReference(cssBootstrapThemeKey);
        CssResourceReference bootstrapCssResourceReference = new CssResourceReference(cssBootstrapKey);
        JavaScriptResourceReference bootstrapJsResourceReference = new JavaScriptResourceReference(jsBootstrapKey);

        
        getResourceBundles().addCssBundle(WicketApplication.class, BOOTSTRAP_CSS_BUNDLE, bootstrapCssResourceReference, bootstrapThemeCssResourceReference);
        getResourceBundles().addJavaScriptBundle(WicketApplication.class, BOOTSTRAP_JS_BUNDLE, bootstrapJsResourceReference);
        
        setHeaderResponseDecorator(this::decorate);
    }
    
    private IHeaderResponse decorate(IHeaderResponse response) {
        return new JavaScriptFilteredIntoFooterHeaderResponse(response, JS_FOOTER_CONTAINER_NAME);
    }
    
}
