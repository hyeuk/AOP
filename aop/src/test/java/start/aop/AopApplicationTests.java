package start.aop;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import start.aop.order.OrderRepository;
import start.aop.order.OrderService;
import start.aop.order.aop.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

@Slf4j
@SpringBootTest
@Import({Aspect5.LogAspect.class,Aspect5.TxAspect.class})
public class AopApplicationTests {
	@Autowired
	OrderService orderService;
	@Autowired
	OrderRepository orderRepository;
	@Test
	void aopInfo() {
		log.info("isAopProxy, orderService={}", AopUtils.isAopProxy(orderService));
		log.info("isAopProxy, orderRepository={}",AopUtils.isAopProxy(orderRepository) );
	}

	@Test
	void success(){
		orderService.orderItem("itemA");
	}

	@Test
	void exception(){
		assertThatThrownBy(() ->orderService.orderItem("ex")).isInstanceOf(IllegalStateException.class);
	}

}
