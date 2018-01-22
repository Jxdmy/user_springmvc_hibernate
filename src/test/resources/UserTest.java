

//指定Spring配置文件位置  
@ContextConfiguration("/applicationContext-*.xml")
@RunWith(SpringJUnit4ClassRunner.class) 
public class UserTest {

	// 可以直接使用Spring Annotation的方式注入  
    @Autowired
    private UserDaoImpl userDaoImpl;
}
