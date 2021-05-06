import React from "react";
import ZooService from "../Services/ZooService";

class RenderZoo extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      zoomap: [],
    };
  }

  componentDidMount() {
    this.fetchZooClass();
  }

  fetchZooClass() {
    ZooService.fetchZoo()
      .then(r => {
        this.setState({
          zoomap: r.data,
        });
      })
      .catch(e => console.log(e));
  }

  render() {
    return (
      <div className='test'>
        {this.state.zoomap.map(e => {
          return (
            <div className='zooContainer'>
              {e.id} {e.zooMapId}
              <button
                type='submit'
                style={{ marginLeft: "15px" }}
                onClick={() => {
                  ZooService.deleteZoo(e.id);
                  window.location.reload(false);
                }}
              >
                Delete me
              </button>
            </div>
          );
        })}
      </div>
    );
  }
}

export default RenderZoo;
