package cn.fjnu.officeSystem.dao;

import org.springframework.stereotype.Repository;

import cn.fjnu.officeSystem.entity.ItemSend;

@Repository
public interface ItemSendDao {
	
	public int insertItemSend(ItemSend itemSend);
	
	

}
