/**
 * MyBatisLogHolder.java
 * @since 2014年6月13日
 */
package me.link98.core.utils.mybatis;

import org.apache.ibatis.logging.LogFactory;

/**
 * @desc mybatis日志工具
 * @author fengmengyue
 *
 * @since 2014年6月13日
 */
public class MyBatisLogHolder {
	/**
     * 使用log4j
     */
    public void useLog4JLogger(){
            LogFactory.useLog4JLogging();
    }
}
