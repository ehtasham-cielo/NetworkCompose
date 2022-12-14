# NetworkCompose

#### This library Provide Network State handler to check the state of Network

Create Instance of Network State Class

    private val networkState by lazy { NetworkState(this.application) }

This class inherit from live data , so you can observe the state of network

    networkState.observe(this@LoginActivity){ state ->
       when(state) {
          true   -> { Connected }
	  false  -> { Disconnected }
	}
    }
 
This Project Incudes all Restful Api's Related to Cielo

### Step 1- To get access of api's you need two instance

ApiInterface & the ApiRepository that contains the handling of Api's

    private val apiInterface by lazy { ApiInterface.Instance }
    private val apiRepository by lazy { ApiRepository( apiInterface ) }
