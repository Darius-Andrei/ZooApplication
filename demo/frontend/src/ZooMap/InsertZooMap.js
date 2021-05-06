import React, {useState} from 'react';
import ZooMapService from '../Services/ZooMapService.js';

const InsertZooMap = (props) => {
    const [zooMapToAdd, setZooMap] = useState({
        id: null,
        zoo: null,
        animals: null,
    });


    
    const finishInsert = (e) => {
        e.preventDefault();
        var data = {
            id: zooMapToAdd.id,
            zoo: zooMapToAdd.zoo,
            animals: zooMapToAdd.animals,
        };

    ZooMapService.addZooMap(data).then(r => {
            setZooMap({...zooMapToAdd, id: r.data.id, zoo: r.data.zoo, animals: r.data.animals,});
            window.location.reload(false);
        }).catch(e => {console.log(e)})
    };

    return (
        <div>
        <form className="myform">

            <label >Create:</label>
            <button
            type="submit"
            onClick={finishInsert}
            className="btn btn-success"
            >
            Create Zoo!
            </button>
        </form>
        </div>
    );
}

export default InsertZooMap;
