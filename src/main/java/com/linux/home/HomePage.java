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
package com.linux.home;

import static com.linux.WicketApplication.CSS_BOOTSTRAP;
import static com.linux.WicketApplication.CSS_BOOTSTRAP_THEME;
import static com.linux.WicketApplication.JS_BOOTSTRAP;
import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.head.JavaScriptReferenceHeaderItem;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.ResourceModel;
import org.apache.wicket.request.Url;
import org.apache.wicket.request.resource.UrlResourceReference;

/**
 *
 * @author guru.a.kulkarni
 */
public class HomePage extends WebPage {
    

    @Override
    protected void onInitialize() {
        super.onInitialize();
        add(new Label("helloWicket", new ResourceModel("helloWicket")));
    }

    @Override
    public void renderHead(IHeaderResponse response) {
        response.render(CSS_BOOTSTRAP);
        response.render(CSS_BOOTSTRAP_THEME);
        response.render(JS_BOOTSTRAP);
    }
    
    
}
