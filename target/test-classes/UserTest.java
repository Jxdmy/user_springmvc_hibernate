

//ָ��Spring�����ļ�λ��  
@ContextConfiguration("/applicationContext-*.xml")
@RunWith(SpringJUnit4ClassRunner.class) 
public class UserTest {

	// ����ֱ��ʹ��Spring Annotation�ķ�ʽע��  
    @Autowired
    private UserDaoImpl userDaoImpl;
}
