import Ember from 'ember';
import DS from 'ember-data';

export default Ember.Controller.extend({

    actions : {
        //POST Request an die API mit einem neuen Buch Objekt 
        anlegen: function(buchRecord) {
            buchRecord.save();
            this.transitionToRoute('buch.bearbeiten');
        }
    }
    
});
