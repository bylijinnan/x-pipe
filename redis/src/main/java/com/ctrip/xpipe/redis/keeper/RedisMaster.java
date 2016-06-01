package com.ctrip.xpipe.redis.keeper;

import com.ctrip.xpipe.exception.XpipeException;
import com.ctrip.xpipe.redis.protocal.PsyncObserver;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;

/**
 * @author wenchao.meng
 *
 * May 20, 2016 3:54:13 PM
 */
public interface RedisMaster extends RedisRole, PsyncObserver{
	
	void startReplication();

	void stopReplication();

	/**
	 * @param channel
	 * @param msg
	 * @throws XpipeException 
	 */
	void handleResponse(Channel channel, ByteBuf msg) throws XpipeException;

	/**
	 * @param channel
	 */
	void masterDisconntected(Channel channel);

	/**
	 * @param channel
	 */
	void masterConnected(Channel channel);
	
	
	
}