import org.springframework.cloud.contract.spec.Contract
import org.springframework.http.HttpStatus

Contract.make {
    description("Should return a list of fraudsters")
    request {
        url "/fraudster"
        method GET()
    }

    response {
        status HttpStatus.OK.value()
        headers {
            header 'Content-Type': 'application/json;charset=UTF-8'
        }
        body '''
            [  
               {  
                  "name":"John",
                  "age":10
               }
            ]
        '''
    }
}