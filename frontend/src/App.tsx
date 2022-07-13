import Header from "./componentes/Header";
import NotificationButton from "./componentes/NotificationButton";
import SalesCard from "./componentes/SalesCard";

function App() {
  return (
    <>
      <Header />
      <main>
        <section id="sales">
          <div className="dsmeta-container">
            <SalesCard />
          </div>
        </section>
      </main>
    </>
  )
}

export default App;
