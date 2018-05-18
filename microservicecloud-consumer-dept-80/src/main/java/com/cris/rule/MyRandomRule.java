package com.cris.rule;

import java.util.List;

import org.omg.IOP.TAG_ORB_TYPE;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

public class MyRandomRule extends AbstractLoadBalancerRule {
    
  /*  Random rand;

    public RandomRule() {
        rand = new Random();
    }*/

    // 当前服务模块的轮次
    private Integer currentCount = 0;
    // 调用当前服务模块的次数
    private Integer totalCount = 5;
    
    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }
        Server server = null;

        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }
            List<Server> upList = lb.getReachableServers();
            List<Server> allList = lb.getAllServers();

            int serverCount = allList.size();
            if (serverCount == 0) {
                /*
                 * No servers. End regardless of pass, because subsequent passes only get more
                 * restrictive.
                 */
                return null;
            }
            
            /*int index = rand.nextInt(serverCount);
            server = upList.get(index);*/
            
            if(totalCount > 0) {
                server = upList.get(currentCount);
                totalCount --;
            }else {
                totalCount = 5;
                ++currentCount;
                if (currentCount >= upList.size()) {
                    currentCount = 0;
                }
//                server = allList.get(currentCount);
            }
            

            if (server == null) {
                /*
                 * The only time this should happen is if the server list were somehow trimmed.
                 * This is a transient condition. Retry after yielding.
                 */
                Thread.yield();
                continue;
            }

            if (server.isAlive()) {
                return (server);
            }

            // Shouldn't actually happen.. but must be transient or a bug.
            server = null;
            Thread.yield();
        }

        return server;

    }

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {
        // TODO Auto-generated method stub

    }

}
