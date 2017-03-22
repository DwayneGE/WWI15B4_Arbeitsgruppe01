import Ember from 'ember';
import DS from 'ember-data';

export default Ember.Controller.extend({

     actions: {

        löschen: function(id) {
            this.get('store').findRecord('buch', id).then(function (buch) {
            buch.destroyRecord();
            }); 
        },

        ändernÖffnen: function (id) {
            this.transitionToRoute('ändern', id);
        }
    }
});
