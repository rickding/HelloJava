// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) ansi 
// Source File Name:   JPATraversableResolver.java

package org.hibernate.validator.internal.engine.resolver;

import java.lang.annotation.ElementType;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUtil;
import javax.validation.Path;
import javax.validation.TraversableResolver;
import org.hibernate.validator.internal.util.logging.Log;
import org.hibernate.validator.internal.util.logging.LoggerFactory;

public class JPATraversableResolver
    implements TraversableResolver
{

    public JPATraversableResolver()
    {
    }

    public final boolean isReachable(Object traversableObject, javax.validation.Path.Node traversableProperty, Class rootBeanType, Path pathToTraversableObject, ElementType elementType)
    {
//        if(log.isTraceEnabled())
//            log.tracef("Calling isReachable on object %s with node name %s.", traversableObject, traversableProperty.getName());
//        if(traversableObject == null)
//            return true;
//        else
//            return Persistence.getPersistenceUtil().isLoaded(traversableObject, traversableProperty.getName());
        return true;
    }

    public final boolean isCascadable(Object traversableObject, javax.validation.Path.Node traversableProperty, Class rootBeanType, Path path, ElementType elementtype)
    {
        return true;
    }

    private static final Log log = LoggerFactory.make();

}
