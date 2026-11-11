One

Own custom functional interface 2 inputs and returns String concat

@FunctionalInterface
interface OwnCustom{

    String concat(String s1, String s2);

}

main(){
OwnCustom ownCustom = (s1, s2)->s1+s2;
ownCustom.concat("hari", "babu");

}

Find the most expensive item in each category
 
i

public class UserService {
 
private final UserRepository repo;
private final AnotherService anotherService;
 
constructor();
 
@Transactional
public void saveUser(User user){
   UserEntity userEntity = UserEntityAssembler.toEntity(user);
   repo.save(userEntity);
   anotherService.doSomethingElse();
}
}
 
@Service
public class AnotherService {
 
private final AnotherRepo repo;
 
@Transactional(propagation=REQUIRE_NEW)
public void doSomethingElse(){
   repo.save(anotherEnitity);
   throw new RuntimeException("Exception thrown");
}
}

