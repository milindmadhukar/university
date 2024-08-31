import './Project.css'

const Project = (props) => {
  return (
    <div class='project'>
      <img 
        height={'100px'}
        src={props.img}
        alt='project'
      />
      <h2>{props.name}</h2>
      <p>{props.description}</p>
      <a href={props.link}>View Project</a>
    </div>
  )
}

export default Project
