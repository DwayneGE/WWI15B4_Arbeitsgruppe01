export default function () {

  //this.namespace = '';

  this.get('/buches', function () {
    return {
      data: [{
        type: 'buch',
        id: 1,
        attributes: {
          titel: 'software-engineering',
          auflage: 2,
          verlag: 'springer'
        }
      },
      {
        type: 'buch',
        id: 2,
        attributes: {
          titel: 'software-engineering 2',
          auflage: 2,
          verlag: 'springer'
        }
      }]
    };
  });

  this.get('/buches/1', function () {
    return {data:{
      type: 'buch',
      id: 1,
      attributes: {
        titel: 'software-engineering',
        auflage: 2,
        verlag: 'springer'
      }
    }}
  });
}