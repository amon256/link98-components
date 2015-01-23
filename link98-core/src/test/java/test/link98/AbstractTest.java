/**
 * AbstractTest.java
 * @create by fengmengyue
 * @since 2015年1月22日
 */
package test.link98;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**  
 * <b>Description：</b> 对功能点的描述<br/>
 * <b>@author： </b>fengmengyue<br/>
 * <b>@date：</b>2015年1月22日 <br/>     
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext-dao.xml"},inheritInitializers=true,inheritLocations=true)
public class AbstractTest {

}
