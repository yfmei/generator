/*
 * Copyright (c) 2011-2020, baomidou (jobob@qq.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * https://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.baomidou.mybatisplus.generator.config.builder;

import com.baomidou.mybatisplus.generator.config.ConstVal;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.function.ConverterFileName;
import org.jetbrains.annotations.NotNull;

/**
 * 控制器属性配置
 *
 * @author nieqiurong 2020/10/11.
 * @since 3.4.1
 */
public class Mapper {

    private Mapper() {
    }

    /**
     * 自定义继承的Mapper类全称，带包名
     */
    private String superClass = ConstVal.SUPER_MAPPER_CLASS;

    /**
     * 开启 BaseResultMap
     *
     * @since 3.4.1
     */
    private boolean baseResultMap;

    /**
     * 开启 baseColumnList
     *
     * @since 3.4.1
     */
    private boolean baseColumnList;

    /**
     * 是否在xml中添加二级缓存配置
     *
     * @since 3.4.1
     */
    private boolean enableXmlCache;

    /**
     * 转换输出Mapper文件名称
     *
     * @since 3.4.1
     */
    private ConverterFileName converterMapperFileName = (entityName -> entityName + ConstVal.MAPPER);

    /**
     * 转换输出Xml文件名称
     *
     * @since 3.4.1
     */
    private ConverterFileName converterXmlFileName = (entityName -> entityName + ConstVal.XML);


    public String getSuperClass() {
        return superClass;
    }

    public boolean isBaseResultMap() {
        return baseResultMap;
    }

    public boolean isBaseColumnList() {
        return baseColumnList;
    }

    public boolean isEnableXmlCache() {
        return enableXmlCache;
    }

    public ConverterFileName getConverterMapperFileName() {
        return converterMapperFileName;
    }

    public ConverterFileName getConverterXmlFileName() {
        return converterXmlFileName;
    }

    public static class Builder extends BaseBuilder {

        private final Mapper mapper = new Mapper();

        public Builder(StrategyConfig strategyConfig) {
            super(strategyConfig);
        }

        /**
         * 父类Mapper
         *
         * @param superClass 类名
         * @return this
         */
        public Builder superClass(String superClass) {
            this.mapper.superClass = superClass;
            return this;
        }

        /**
         * 父类Mapper
         *
         * @param superClass 类
         * @return this
         * @since 3.4.1
         */
        public Builder superClass(@NotNull Class<?> superClass) {
            return superClass(superClass.getName());
        }

        /**
         * 开启baseResultMap
         *
         * @param baseResultMap 是否开启baseResultMap
         * @return this
         * @since 3.4.1
         */
        public Builder baseResultMap(boolean baseResultMap){
            this.mapper.baseResultMap = baseResultMap;
            return this;
        }

        /**
         * 开启baseColumnList
         *
         * @param baseColumnList 是否开启baseColumnList
         * @return this
         * @since 3.4.1
         */
        public Builder baseColumnList(boolean baseColumnList) {
            this.mapper.baseColumnList = baseColumnList;
            return this;
        }

        /**
         * 是否在xml中添加二级缓存配置
         *
         * @param enableXmlCache 是否开启
         * @return this
         */
        public Builder enableXmlCache(boolean enableXmlCache) {
            this.mapper.enableXmlCache = enableXmlCache;
            return this;
        }

        /**
         * 输出Mapper文件名称转换
         *
         * @param converter 　转换处理
         * @return this
         * @since 3.4.1
         */
        public Builder convertMapperFileName(@NotNull ConverterFileName converter) {
            this.mapper.converterMapperFileName = converter;
            return this;
        }

        /**
         * 转换Xml文件名称处理
         *
         * @param converter 　转换处理
         * @return this
         * @since 3.4.1
         */
        public Builder convertXmlFileName(@NotNull ConverterFileName converter) {
            this.mapper.converterXmlFileName = converter;
            return this;
        }


        /**
         * 格式化Mapper文件名称
         *
         * @param format 　格式
         * @return this
         * @since 3.4.1
         */
        public Builder formatMapperFileName(String format) {
            return convertMapperFileName((entityName) -> String.format(entityName, format));
        }

        /**
         * 格式化Xml文件名称
         *
         * @param format 格式
         * @return this
         * @since 3.4.1
         */
        public Builder formatXmlFileName(String format) {
            return convertXmlFileName((entityName) -> String.format(entityName, format));
        }

        public Mapper get() {
            return this.mapper;
        }
    }
}
