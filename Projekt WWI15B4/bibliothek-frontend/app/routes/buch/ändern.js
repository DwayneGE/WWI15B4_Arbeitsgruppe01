import Ember from 'ember';

export default Ember.Route.extend({
    model(params){
        //GET Request
        //Das zu ändern gewünschte Buch wird aus dem DataStore durch die angehängte ID bezogen und der View übergeben
        return this.get('store').findRecord('buch', params.buchid);

        }
});
