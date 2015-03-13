User = Backbone.Model.extend({	
	urlRoot: function() {
		return this.url;
	},
	initialize : function(userName) {
		this.url = './json/yavni/users/'+userName;
		console.log("Welcome to this world"+userName);
	},
	
	toString: function() {
		return 'userId: '+this.userId+'\tuserName: '+this.userName;
	}
});

//var person = new Person;