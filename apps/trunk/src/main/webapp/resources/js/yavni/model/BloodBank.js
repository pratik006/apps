User = Backbone.Model.extend({	
	urlRoot: function() {
		return this.url;
	},
	initialize : function(userBame) {
		this.url = './json/yavni/banks/'+userBank;
	},
	
	toString: function() {
		return 'userId: '+this.userId+'\tuserName: '+this.userName;
	}
});
