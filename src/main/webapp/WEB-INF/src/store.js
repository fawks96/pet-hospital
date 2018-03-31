  import Vue from 'vue';
  import Vuex from 'vuex';
  Vue.use(Vuex);

  var store = new Vuex.Store({
  	state: {
  		user: {}
  	},
  	mutations: {
  		login (state, value) {
  			state.user = value
  		}
  	},
  	actions: {

  	}
  })
  export default store