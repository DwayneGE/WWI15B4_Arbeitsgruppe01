import Ember from 'ember';
import DS from 'ember-data';

export default Ember.Controller.extend({

     actions: {

        suche: function(titel) {
            if (titel !== '') {
                return this.get('store').find('buch', titel);
            } else {
                return;
            }
        },

        löschen: function(id) {
            store.find('buch', id).then(function (buch) {
            buch.destroyRecord();
            });
        }
    }
});
