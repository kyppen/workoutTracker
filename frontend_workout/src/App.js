import React, { useEffect, useState } from 'react';
import Greeting from './Greeting'



function FetchGymPlanComponent(){
  const [data, setData] = useState(null)

  const fetchData = async () => {
    try {
      const response = await fetch('http://localhost:8083/randomPlan');
      const result = await response.json();
      setData(result); // Store fetched data in state
      console.log(result)
    } catch (error) {
      console.error('Error fetching data:', error);
    }
  };

  return (
      <div>
        {/* Step 3: Button to trigger data fetch */}
        <button onClick={fetchData}>/randomPlan</button>

        {/* Step 4: Display fetched data */}
        {data && (
            <div>
              <h2>{data}</h2>
            </div>
        )}
      </div>
  );
}


function App() {
  return (
      <div className="App">
        <h1>My React App</h1>
          <Greeting greeting={"XD"}/>
        {/* Step 2: Use the DataFetchingComponent */}
        <FetchGymPlanComponent />
      </div>
  );
}

export default App;
