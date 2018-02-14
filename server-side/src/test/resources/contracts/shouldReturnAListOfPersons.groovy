package contract

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description("should return a list of persons")
    request {
        url "/person"
        method GET()
    }
    response {
        status 200
        body '''\
		{
          "name": "Sample Person Name",
          "age" : "16",
          "address" : {
            "street" : "Boulevard",
            "number" : 123,
            "zipcode" : "04330123"
          }
        }
	'''
    }
}