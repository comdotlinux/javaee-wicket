/*
 * Copyright (C) 2016 comdotlinux <guru@linux.com>
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
import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.head.JavaScriptReferenceHeaderItem;
import org.apache.wicket.request.Url;
import org.apache.wicket.request.resource.UrlResourceReference;

/**
 *
 * @author guru.a.kulkarni
 */
public class WicketApplication extends WebApplication {

    /**  */
    public static final JavaScriptReferenceHeaderItem JS_BOOTSTRAP = JavaScriptHeaderItem.forReference(new UrlResourceReference(Url.parse("https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js")));
    
    /**  */
    public static final CssReferenceHeaderItem CSS_BOOTSTRAP_THEME = CssHeaderItem.forReference(new UrlResourceReference(Url.parse("https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css")));
    
    /**  */
    public static final CssReferenceHeaderItem CSS_BOOTSTRAP = CssHeaderItem.forReference(new UrlResourceReference(Url.parse("https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css")));
    
    /** {@inheritDoc} */
    @Override
    public Class<? extends Page> getHomePage() {
        return HomePage.class;
    }
}
