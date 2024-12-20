for i in 1..10 
 echo $i 
end 
1NEKE24O1KRSE76JEC4OFFMQ

set mypid 742; set SSH_AUTH_SOCK /tmp/ssh-ROI79vOnqRsb/agent.$(Math `mypid -1`); export SSH_AUTH_SOCK;
set SSH_AGENT_PID $mypid; export SSH_AGENT_PID;
echo Agent pid $mypid;
# 
# transform:
ssh-agent -s
# from:
SSH_AUTH_SOCK=/tmp/ssh-eJm7zlfeeTKi/agent.163; export SSH_AUTH_SOCK;
SSH_AGENT_PID=164; export SSH_AGENT_PID;
echo Agent pid 164;
# to:
set SSH_AUTH_SOCK /tmp/ssh-eJm7zlfeeTKi/agent.163; export SSH_AUTH_SOCK;
set SSH_AGENT_PID 164; export SSH_AGENT_PID;
echo Agent pid 164;

set res  $(string split ';' input)
set pid $(string split '=' res[2])
res[2]