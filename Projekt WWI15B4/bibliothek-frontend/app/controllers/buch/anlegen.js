import Ember from 'ember';
import DS from 'ember-data';

export default Ember.Controller.extend({

    actions : {
        anlegen: function(buchRecord) {
            buchRecord.save();
            this.transitionToRoute('buch.bearbeiten');
        }
    }
    
});
