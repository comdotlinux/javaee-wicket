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
import java.util.ArrayList;
import java.util.List;
import org.apache.wicket.extensions.ajax.markup.html.tabs.AjaxTabbedPanel;
import org.apache.wicket.extensions.markup.html.tabs.ITab;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.ResourceModel;
import static org.apache.wicket.util.lang.Args.notNull;

/**
 *
 * @author guru.a.kulkarni
 */
public class HomePage extends WebPage {
    

    @Override
    protected void onInitialize() {
        super.onInitialize();
        List<Tab> tabs = new ArrayList<>();
        
//        IModel<Boolean> projectNameTabVisible = new Model<>(true);
//        Tab projectName = new Tab(new ResourceModel("projectNameTabTitle"), projectNameTabVisible);
//        tabs.add(projectName);
        
        IModel<Boolean> homeTabVisible = new Model<>(true);
        Tab home = new Tab(new ResourceModel("homeTabTitle"), homeTabVisible);
        tabs.add(home);
        
        IModel<Boolean> aboutTabVisible = new Model<>(true);
        Tab about = new Tab(new ResourceModel("aboutTabTitle"), aboutTabVisible);
        tabs.add(about);
        
        IModel<Boolean> contactTabVisible = new Model<>(true);
        Tab contact = new Tab(new ResourceModel("contactTabTitle"), contactTabVisible);
        tabs.add(contact);
        
        add(new AjaxTabbedPanel<Tab>("tabPanel", tabs){
            @Override
            protected String getSelectedTabCssClass() {
                return "active";
            }
            
            get
        });
        add(new Label("helloWicket", new ResourceModel("helloWicket")));
    }

    @Override
    public void renderHead(IHeaderResponse response) {
        response.render(CSS_BOOTSTRAP);
        response.render(CSS_BOOTSTRAP_THEME);
        response.render(JS_BOOTSTRAP);
    }
    
    private class Tab implements ITab{

        private final IModel<String> title;
        private WebMarkupContainer panel;
        private final IModel<Boolean> isVisible;
        
        Tab(final IModel<String> title, final IModel<Boolean> isVisible) {
            this.title = notNull(title, "title");
            this.isVisible = notNull(isVisible, "isVisible");
        }

        @Override
        public IModel<String> getTitle() {
            return title;
        }

        @Override
        public WebMarkupContainer getPanel(String containerId) {
            if( panel == null ) {
                panel = new WebMarkupContainer(containerId);
            }
            return panel;
        }

        @Override
        public boolean isVisible() {
            return null != isVisible && null != isVisible.getObject() && isVisible.getObject();
        }
        
    }
}
