package cn.fjnu.officeSystem.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.fjnu.officeSystem.entity.BackgroundCategoriesMenu;
@Repository
public interface BackgroundCategoriesMenuDao {
	/**
	 * 添加后台管理菜单表的信息
	 * @param backgroundCategoriesMenu
	 * @return
	 */
    public int insertBackgroundCategoriesMenu(BackgroundCategoriesMenu  backgroundCategoriesMenu);
	
   
    /**
     *  更改后台管理菜单表的信息
     * @param backgroundCategoriesMenu
     * @return
     */
	public int updateBackgroundCategoriesMenu(BackgroundCategoriesMenu  backgroundCategoriesMenu);
	
	/**
	 * 通过id查询后台管理菜单表的信息
	 * @param id
	 * @return
	 */
	public BackgroundCategoriesMenu selectBackgroundCategoriesMenuById(String id);
	
    /**
     * 通过权限ids查询后台管理菜单集合
     * @param permissionIds
     * @return
     */
	public List<BackgroundCategoriesMenu> selectBackgroundCategoriesMenusByPermissionIds(List<String> permissionIds);
	
	

}
