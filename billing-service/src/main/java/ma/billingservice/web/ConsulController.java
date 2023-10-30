package ma.billingservice.web;

import ma.billingservice.config.ConsulConfig;
import ma.billingservice.config.VaultConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
//@RefreshScope
public class ConsulController {
    @Autowired
    private ConsulConfig consulConfig;
    @Autowired
    private VaultConfig vaultConfig;
//    @Value("${token.accessTokenTimeout}")
//    private long accessTokenTimeout;
//    @Value("${token.refreshTokenTimeout}")
//    private long refreshTokenTimeout;
    @GetMapping("/myConfig")
    public Map<String,Object> myConfig(){
        //return Map.of("accessTokenTimeout", accessTokenTimeout, "refreshTokenTimeout", refreshTokenTimeout);
        return Map.of("consulConfig",consulConfig, "vaultConfig",vaultConfig);    }
}
