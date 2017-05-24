package com.springbootredis.service.impl;


import com.springbootredis.bean.DemoInfo;
import com.springbootredis.repository.DemoInfoRepository;
import com.springbootredis.service.DemoInfoService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 
 *DemoInfo数据处理类
 * 
 * @author Angel(QQ:412887952)
 * @version v.0.1
 */
@Service
public class DemoInfoServiceImpl implements DemoInfoService {
	
	@Resource
	private DemoInfoRepository demoInfoRepository;
	
	@Resource
	private RedisTemplate<String,String> redisTemplate;
	
	@Override
	public void test(){
		ValueOperations<String,String> valueOperations = redisTemplate.opsForValue();
		valueOperations.set("mykey4", "random1="+Math.random());
		System.out.println(valueOperations.get("mykey4"));
	}

	//keyGenerator="myKeyGenerator"
	@Cacheable(value="demoInfo") //缓存,这里没有指定key.
	@Override
	public DemoInfo findById(long id) {
		System.err.println("DemoInfoServiceImpl.findById()=========从数据库中进行获取的....id="+id);
		return demoInfoRepository.findOne(id);

	}
	
	@CacheEvict(value="demoInfo")
	@Override
	public void deleteFromCache(long id) {
		System.out.println("DemoInfoServiceImpl.delete().从缓存中删除.");
	}
	
}
	/*Cacheable 支持如下几个参数：
		value：缓存位置名称，不能为空，如果使用EHCache，就是ehcache.xml中声明的cache的name
		key：缓存的key，默认为空，既表示使用方法的参数类型及参数值作为key，支持SpEL
		condition：触发条件，只有满足条件的情况才会加入缓存，默认为空，既表示全部都加入缓存，支持SpEL
		以下有一个例子：

		1.  //将缓存保存进andCache，并使用参数中的userId加上一个字符串(这里使用方法名称)作为缓存的key
		2.  @Cacheable(value="andCache",key="#userId + 'findById'")
3.  public SystemUser findById(String userId) {
		4.      SystemUser user = (SystemUser) dao.findById(SystemUser.class, userId);
		5.      return user ;
		6.  }
		7.  //将缓存保存进andCache，并当参数userId的长度小于32时才保存进缓存，默认使用参数值及类型作为缓存的key
		8.  @Cacheable(value="andCache",condition="#userId.length < 32")
9.  public boolean isReserved(String userId) {
		10.    System.out.println("hello andCache"+userId);
		11.    return false;
		12.}
 */

/*
@CacheEvict 支持如下几个参数：
		value：缓存位置名称，不能为空，同上
		key：缓存的key，默认为空，同上
		condition：触发条件，只有满足条件的情况才会清除缓存，默认为空，支持SpEL
		allEntries：true表示清除value中的全部缓存，默认为false


		以下是一个小例子：

		1.  //清除掉指定key的缓存
		2.  @CacheEvict(value="andCache",key="#user.userId + 'findById'")
3.  public void modifyUserRole(SystemUser user) {
		4.           System.out.println("hello andCache delete"+user.getUserId());
		5.  }
		6.
		7.  //清除掉全部缓存
		8.  @CacheEvict(value="andCache",allEntries=true)
9.  public void setReservedUsers() {
		10.    System.out.println("hello andCache deleteall");
		11.}  */
