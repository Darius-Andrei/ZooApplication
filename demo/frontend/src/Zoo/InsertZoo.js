import React, {useState} from 'react';
import ZooService from '../Services/ZooService';

const InsertZoo = (props) => {
    const [zooToAdd, setZoo] = useState({
        id: null,
        zooMap: null,
        souvenirs: null,
    });


    
    const finishInsert = (e) => {
        e.preventDefault();
        var data = {
            id: zooToAdd.id,
            zooMap: zooToAdd.zooMap,
            souvenirs: zooToAdd.souvenirs,
        };

    ZooService.addZoo(data).then(r => {
            setZoo({...zooToAdd, id: r.data.id, zooMap: r.data.zooMap, souvenirs: r.data.souvenirs,});
            window.location.reload(false);
        }).catch(e => {console.log(e)})
    };

    return (
        <div>
        <form className="myform">
            <label htmlFor="username">Create:</label>
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

export default InsertZoo;
