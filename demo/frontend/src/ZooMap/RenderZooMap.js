import React from "react";
import ZooMapService from "../Services/ZooMapService";
import { BrowserRouter as Route, Redirect } from "react-router-dom";
import "./ZooMapCss.css";

class RenderZooMap extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      zoomaps: [],
    };
  }

  componentDidMount() {
    this.fetchZooMapClass();
  }

  fetchZooMapClass() {
    ZooMapService.fetchZooMap()
      .then((r) => {
        this.setState({
          zoomaps: r.data,
        });
      })
      .catch((e) => console.log(e));
  }

  render() {
    let topPositionArrays = [73, 57, 45, 50, 40, 12, 12, 34];
    let leftPositionArrays = [50, 100, 250, 440, 365, 200, 100, 80];
    var freeButtons=[];
    console.log(this.state.zoomaps);
    if(this.state.zoomaps.length!==0){
      for (
        let index = this.state.zoomaps[0].animals.length;
        index < topPositionArrays.length;
        index++
      ) {
       freeButtons.push(
        <button
          className="btn"
          style={{
            position: "absolute",
            top: `${topPositionArrays[index]}%`,
            left: `${leftPositionArrays[index]}%`,
          }}
          type="submit"
        >
          Vacant Place!
        </button>
       );
        }
        console.log(freeButtons);
      }
    
    return (
      <div className="zooMap">
        {this.state.zoomaps &&
          this.state.zoomaps.map((m) => {
            return (
              <div className="container" key={m.id}>
                <img alt="" src={m.url} />
                {m.animals.map((a, index) => {
                  return (
                    <div key={a.id}>
                      <button
                        className="btn"
                        style={{
                          position: "absolute",
                          top: `${topPositionArrays[index]}%`,
                          left: `${leftPositionArrays[index]}%`,
                        }}
                        type="submit"
                        onClick={() => {
                          <Route
                            exact
                            path="/"
                            render={() => {
                              return <Redirect to={a.wikipediaURL} />;
                            }}
                          />;
                          window.location.href = a.wikipediaURL;
                        }}
                      >
                        <img alt="" src={`http://localhost:8080/backend/animals/viewimage/${a.id}`} width="80px" height="100px" />
                      </button>
                    </div>
                  );
                })}
                {freeButtons}
              </div>
            );
          })}
        
      </div>
    );
  }
}

export default RenderZooMap;
