/*
 * <author>Han He</author>
 * <email>me@hankcs.com</email>
 * <create-date>2018-06-21 9:04 AM</create-date>
 *
 * <copyright file="LockableFeatureMap.java">
 * Copyright (c) 2018, Han He. All Rights Reserved, http://www.hankcs.com/
 * This source is subject to Han He. Please contact Han He for more information.
 * </copyright>
 */
package com.hankcs.hanlp.model.perceptron.feature;

import com.hankcs.hanlp.model.perceptron.tagset.TagSet;

/**
 * �?�切�?��?定状�?的特�?id映射
 *
 * @author hankcs
 */
public class LockableFeatureMap extends ImmutableFeatureMDatMap
{
    public LockableFeatureMap(TagSet tagSet)
    {
        super(tagSet);
    }

    @Override
    public int idOf(String string)
    {
        int id = super.idOf(string); // 查询id
        if (id == -1 && mutable) // 如果�?存在该key且处于�?�写状�?
        {
            id = dat.size();
            dat.put(string, id); // 则为key分�?新id
        }
        return id;
    }
}
