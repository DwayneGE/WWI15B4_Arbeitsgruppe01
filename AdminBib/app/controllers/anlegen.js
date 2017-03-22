import Ember from 'ember';

export default Ember.Controller.extend({

    actions : {

        anlegen: function(buchRecord) {
            buchRecord.save();
            this.transitionToRoute('bearbeiten');
        }
    }
});
