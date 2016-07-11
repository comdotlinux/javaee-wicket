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

import static com.linux.WicketApplication.JS_FOOTER_CONTAINER_NAME;
import org.apache.wicket.ResourceBundles;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.head.JavaScriptReferenceHeaderItem;
import org.apache.wicket.markup.head.filter.HeaderResponseContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.ResourceModel;
import org.apache.wicket.request.resource.ResourceReference;
import org.apache.wicket.resource.bundles.ResourceBundleReference;

/**
 *
 * @author guru.a.kulkarni
 */
public class HomePage extends WebPage {

    @Override
    protected void onInitialize() {
        super.onInitialize();
        add(new Label("helloWicket", new ResourceModel("helloWicket")));
        add(new HeaderResponseContainer("jsBody", JS_FOOTER_CONTAINER_NAME));
    }

    @Override
    public void renderHead(IHeaderResponse response) {
        //response.render(JavaScriptHeaderItem.forReference(ResourceBundleReference));
        new ResourceBundleReference();
    }
    
    
}
