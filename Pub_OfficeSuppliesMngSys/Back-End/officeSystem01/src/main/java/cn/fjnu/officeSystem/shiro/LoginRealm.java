package cn.fjnu.officeSystem.shiro;


import javax.annotation.Resource;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;




//public class LoginRealm extends AuthorizingRealm {

//	@Resource
//	public IStaffDao staffDao;
//
//	@Override
//	public void setName(String name) {
//		super.setName("LoginRealm");
//	}
//	
//	//清除缓存。在service修改权限后调用
//	public void clearCached(){
//		PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
//		super.clearCache(principals);
//	}
//	
//	@Override
//	protected AuthenticationInfo doGetAuthenticationInfo(
//			AuthenticationToken token) throws AuthenticationException {
//		System.out.println("我进来了staff认证。。。。。。");
//		String userCode = (String) token.getPrincipal();
//		if(userCode==null)return null;
//		
//		Staff staff = staffDao.selectStaffById(userCode);
//		if(staff==null)return null;
//		
//		String password = staff.getPassword();
//		String salt = staff.getSalt();
//		
//		//把密码的信息删除
//		staff.setPassword("");
//		staff.setSalt("");
//		
//		SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
//				staff, password,ByteSource.Util.bytes(salt), this.getName());
//		
//		System.out.println("结束认证。。。");
//		return simpleAuthenticationInfo;
//	}
//
//	
//	@Override
//	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//		System.out.println("我进入到了staff授权认证");
//		
//		//得到身份信息。需跟登录验证类型一致
//		Staff staff = new Staff();
//		try {
//			staff = (Staff) principals.getPrimaryPrincipal();
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		
//		System.out.println("授权认证:"+ staff.getName());
//			
//		//添加登录授权的身份
//		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
////		StaffRoleEnum[] allStaffRole = StaffRoleEnum.values();
////		String role =null;
////		for (StaffRoleEnum staffRole : allStaffRole) {
////			if(staffRole.getIntValue()==staff.getRole()){
////				role = staffRole.name();
////				System.out.println(role);
////				break;
////			}
////		}
//		
//		simpleAuthorizationInfo.addStringPermission("1");
//		System.out.println("结束授权认证");
//		return simpleAuthorizationInfo;
//
//	}

//}

