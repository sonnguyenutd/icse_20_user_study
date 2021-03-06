/*
 * This file is part of WebLookAndFeel library.
 *
 * WebLookAndFeel library is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * WebLookAndFeel library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with WebLookAndFeel library.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.alee.managers.style.skin.web;

import com.alee.extended.breadcrumb.BreadcrumbUtils;
import com.alee.extended.breadcrumb.WebBreadcrumb;
import com.alee.extended.breadcrumb.WebBreadcrumbPanel;
import com.alee.utils.swing.AncestorAdapter;

import javax.swing.event.AncestorEvent;
import java.awt.*;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;

/**
 * Custom painter for WebBreadcrumbLabel component.
 *
 * @author Mikle Garin
 */

public class WebBreadcrumbPanelPainter<E extends WebBreadcrumbPanel> extends WebPanelPainter<E>
{
    /**
     * Listeners.
     */
    protected ContainerAdapter containerAdapter;
    protected AncestorAdapter ancestorAdapter;

    /**
     * Runtime variables.
     */
    protected WebBreadcrumb breadcrumb = null;

    /**
     * {@inheritDoc}
     */
    @Override
    public void install ( final E c )
    {
        containerAdapter = new ContainerAdapter ()
        {
            @Override
            public void componentAdded ( final ContainerEvent e )
            {
                if ( e.getChild () != c )
                {
                    updateAll ();
                }
            }

            @Override
            public void componentRemoved ( final ContainerEvent e )
            {
                if ( e.getChild () != c )
                {
                    updateAll ();
                }
            }
        };

        ancestorAdapter = new AncestorAdapter ()
        {
            @Override
            public void ancestorAdded ( final AncestorEvent event )
            {
                final Container container = c.getParent ();
                if ( container instanceof WebBreadcrumb )
                {
                    breadcrumb = ( WebBreadcrumb ) container;
                    breadcrumb.addContainerListener ( containerAdapter );
                }
                updateAll ();
            }

            @Override
            public void ancestorRemoved ( final AncestorEvent event )
            {
                removeBreadcrumbAdapter ();
                updateAll ();
            }
        };
        c.addAncestorListener ( ancestorAdapter );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void uninstall ( final E c )
    {
        removeBreadcrumbAdapter ();
        containerAdapter = null;
        c.removeAncestorListener ( ancestorAdapter );
        ancestorAdapter = null;
    }

    /**
     * Removes ContainerAdapter from parent breadcrumb if it exists.
     */
    protected void removeBreadcrumbAdapter ()
    {
        if ( breadcrumb != null )
        {
            breadcrumb.removeContainerListener ( containerAdapter );
            breadcrumb = null;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean isOpaque ( final E c )
    {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Insets getMargin ( final E c )
    {
        return BreadcrumbUtils.getElementMargin ( c );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void paint ( final Graphics2D g2d, final Rectangle bounds, final E c )
    {
        // Painting background
        BreadcrumbUtils.paintElementBackground ( g2d, c );

        // Painting label
        super.paint ( g2d, bounds, c );
    }
}
